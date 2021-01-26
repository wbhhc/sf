package com.chivalry.sf.core;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.chivalry.sf.repository.impl",
        "com.chivalry.sf.business.service"
})
public class SfScannerConfig {
}
