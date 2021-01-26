package com.kingtang.area.sf.core;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
        "com.kingtang.area.sf.repository.impl",
        "com.kingtang.area.sf.business.service"
})
public class SfScannerConfig {
}
