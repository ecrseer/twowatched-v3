package gj.infnet.twSalachat.twSalachat.service;

import gj.infnet.twSalachat.twSalachat.model.SalaChat;
import org.springframework.stereotype.Service;

@Service
public class SalaChatServiceImpl implements SalaChatService {
    private final SalaChatRepository chatRepository;

    public SalaChatServiceImpl(SalaChatRepository chatRepository) {
        this.chatRepository = chatRepository;
    }

    @Override
    public SalaChat save(SalaChat salaChat) {

        return chatRepository.save(salaChat);
    }
}
