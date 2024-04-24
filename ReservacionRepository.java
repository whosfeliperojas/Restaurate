package com.example.Restaurante.Repository;

import com.example.Restaurante.Entitys.Reservacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionRepository extends JpaRepository<Reservacion, Long> {
}
