package br.twowatch.twowatch.service.impl;

import br.twowatch.twowatch.model.SalaChat;
import br.twowatch.twowatch.service.SalaChatRepository;
import br.twowatch.twowatch.service.SalaChatService;
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
