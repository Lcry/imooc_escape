package com.imooc.java.escape.function_interface_lambda;

@FunctionalInterface
public interface IFindWorker {

    Worker findWorkerById(Long id);
}
