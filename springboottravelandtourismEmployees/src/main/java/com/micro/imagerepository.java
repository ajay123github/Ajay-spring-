package com.micro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface imagerepository extends JpaRepository<images, String>{

}
