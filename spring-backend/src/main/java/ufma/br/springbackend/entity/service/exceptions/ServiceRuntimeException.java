package ufma.br.springbackend.entity.service.exceptions;

public class ServiceRuntimeException extends RuntimeException {

    public ServiceRuntimeException(String msg) {
        super(msg);
    }
    
}