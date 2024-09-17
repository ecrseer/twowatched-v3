package gj.infnet.twSalachat.twSalachat.service;

import gj.infnet.twSalachat.twSalachat.model.Mensagem;
import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SalaChatServiceImpl implements SalaChatService {
    private final SalaChatRepository chatRepository;

    public SalaChatServiceImpl(SalaChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public SalaChat save(SalaChat salaChat) {
        salaChat.verificarDados();
        return chatRepository.save(salaChat);
    }

    public SalaChat findById(Long id) {
        Optional<SalaChat> byId = chatRepository.findById(id);
        if (byId.isEmpty()) {
            throw new RuntimeException("SalaChat nao encontrada");
        }
        return byId.get();
    }

    public SalaChat adicionaMensagem(Long salaId, Mensagem msg) {
        SalaChat salaChat = findById(salaId);
        List<Mensagem> mensagens = salaChat.getMensagens();
        mensagens.add(msg);
        salaChat.setMensagens(mensagens);
        return this.chatRepository.save(salaChat);
    }
}
