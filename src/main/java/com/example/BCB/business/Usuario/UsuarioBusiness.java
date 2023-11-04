package com.example.BCB.business.Usuario;

import com.example.BCB.business.Mensagem.MensagemBusiness;
import com.example.BCB.exceptions.ValidacaoException;
import com.example.BCB.model.PlanoModel;
import com.example.BCB.model.UsuarioModel;
import com.example.BCB.persistance.UsuarioRepository;
import com.example.BCB.enums.TipoCobrancaPlano;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class UsuarioBusiness {

    private final static String ERRO_USUARIO_NAO_ENCONTRADO = "Usuário não encontrado.";

    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    UsuarioRepository _usuarioRepository;

    public void criarUsuario(UsuarioModel usuario)
    {
        _usuarioRepository.save(usuario);
    }

    public List<UsuarioModel> getUsuarios() {
        return _usuarioRepository.findAll();
    }

    public UsuarioModel getUsuarioPorId(UUID idUsuario)
    {
        Optional<UsuarioModel> usuario = _usuarioRepository.findById(idUsuario);
        if(usuario.isEmpty())
        {
            throw new ValidacaoException(ERRO_USUARIO_NAO_ENCONTRADO);
        }
        return usuario.get();
    }

    public UsuarioModel getUsuarioPorTelefone(String telefoneUsuario)
    {
        UsuarioModel usuario = _usuarioRepository.findByTelefone(telefoneUsuario);
        if(usuario==null)
        {
            throw new ValidacaoException(ERRO_USUARIO_NAO_ENCONTRADO);
        }
        return usuario;
    }

    public void atualizarUsuario(UsuarioModel usuario)
    {
        _usuarioRepository.save(usuario);
    }

    public void deletarUsuario(UUID idUsuario)
    {
        _usuarioRepository.delete(getUsuarioPorId(idUsuario));
    }

    public boolean VerificarSePodeEnviarMensagem(UsuarioModel usuarioEnvio) {
        PlanoModel planoUsuario = usuarioEnvio.getPlano();

        if(planoUsuario.getTipoCobrancaPlano() == TipoCobrancaPlano.DINHEIRO)
        {
            return usuarioEnvio.getSaldo().compareTo(planoUsuario.getValor()) >= 0;
        }
        else {
            MensagemBusiness mensagemBusiness = applicationContext.getBean(MensagemBusiness.class);
            return mensagemBusiness.QuantidadeDeMensagensDoUsuario(usuarioEnvio.getIdUsuario()) < usuarioEnvio.getLimiteMensagem();
        }
    }

    public void atualizaUsuarioAoEnviarMensagem(UsuarioModel usuarioEnvio)
    {
        PlanoModel planoUsuario = usuarioEnvio.getPlano();

        if(planoUsuario.getTipoCobrancaPlano() == TipoCobrancaPlano.DINHEIRO)
        {
            usuarioEnvio.setSaldo(usuarioEnvio.getSaldo().subtract(planoUsuario.getValor()));
            _usuarioRepository.save(usuarioEnvio);
        }
    }
}
