package gj.infnet.twSalachat.twSalachat.service;

import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import org.springframework.stereotype.Service;

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
}
