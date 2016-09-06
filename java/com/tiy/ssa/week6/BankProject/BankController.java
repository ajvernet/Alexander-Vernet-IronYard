package com.tiy.ssa.week6.BankProject;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tiy.ssa.week5.CustomerDB.AccountDAO;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    AccountDAO accDao;
    

}
