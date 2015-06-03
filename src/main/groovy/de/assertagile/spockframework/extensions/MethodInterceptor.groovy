package de.assertagile.spockframework.extensions

import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation

class MethodInterceptor implements IMethodInterceptor {
    @Override
    void intercept(IMethodInvocation methodInvocation) throws Throwable {
        methodInvocation.proceed()
    }
}
