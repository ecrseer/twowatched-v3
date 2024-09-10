package br.twowatch.twowatch.service;

import br.twowatch.twowatch.model.SalaChat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaChatRepository extends JpaRepository<SalaChat, Long> {
}
