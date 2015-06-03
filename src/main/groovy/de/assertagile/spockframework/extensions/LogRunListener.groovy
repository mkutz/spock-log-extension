package de.assertagile.spockframework.extensions

import groovy.util.logging.Log
import org.spockframework.runtime.IRunListener
import org.spockframework.runtime.model.BlockInfo
import org.spockframework.runtime.model.ErrorInfo
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.IterationInfo
import org.spockframework.runtime.model.SpecInfo

import java.util.logging.Level

@Log
class LogRunListener implements IRunListener {

    @Override
    void beforeSpec(SpecInfo specInfo) {
        log.log(Level.INFO, "LogRunListener before spec '${specInfo.name}'")
    }

    @Override
    void afterSpec(SpecInfo specInfo) {
        log.log(Level.INFO, "LogRunListener after spec '${specInfo.name}'")
    }

    @Override
    void specSkipped(SpecInfo specInfo) {
        log.log(Level.INFO, "LogRunListener skipped spec '${specInfo.name}'")
    }


    @Override
    void beforeFeature(FeatureInfo featureInfo) {
        log.log(Level.INFO, "LogRunListener before spec '${featureInfo.name}'")
        featureInfo.featureMethod.addInterceptor()
        featureInfo.blocks.each { BlockInfo blockInfo ->
            blockInfo.texts.each { String text -> log.log(Level.INFO, "${blockInfo.kind} ${text}") }
        }
    }

    @Override
    void featureSkipped(FeatureInfo featureInfo) {
        log.log(Level.INFO, "LogRunListener skipped feature '${featureInfo.name}'")
    }

    @Override
    void afterFeature(FeatureInfo featureInfo) {
        log.log(Level.INFO, "LogRunListener after feature '${featureInfo.name}'")
    }


    @Override
    void beforeIteration(IterationInfo iterationInfo) {
        log.log(Level.INFO, "LogRunListener before iteration '${iterationInfo.name}'")
    }

    @Override
    void afterIteration(IterationInfo iterationInfo) {
        log.log(Level.INFO, "LogRunListener after iteration '${iterationInfo.name}'")
    }


    @Override
    void error(ErrorInfo errorInfo) {
        log.log(Level.INFO, "LogRunListener error '${errorInfo.exception}'")
    }
}
