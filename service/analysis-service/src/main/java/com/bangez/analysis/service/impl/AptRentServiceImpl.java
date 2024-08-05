package com.bangez.analysis.service.impl;
import com.bangez.analysis.repository.AptRentRepository;
import com.bangez.analysis.service.AptRentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AptRentServiceImpl implements AptRentService{
    private final AptRentRepository repository;
}
