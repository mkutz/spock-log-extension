package de.assertagile.spockframework.extensions

import groovy.util.logging.Log
import org.spockframework.runtime.extension.IGlobalExtension
import org.spockframework.runtime.model.SpecInfo

import java.util.logging.Level

@Log
class LogExtension implements IGlobalExtension {


    @Override
    void start() {
        log.log(Level.INFO, "LogExtension was started...")
    }

    @Override
    void visitSpec(SpecInfo specInfo) {
        log.log(Level.INFO, "...visiting ${specInfo.name}...")
        specInfo.addListener(new LogRunListener())
    }

    @Override
    void stop() {
        log.log(Level.INFO, "LogExtension was stopped.")
    }
}