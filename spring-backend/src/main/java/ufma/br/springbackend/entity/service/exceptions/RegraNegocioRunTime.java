package ufma.br.springbackend.entity.service.exceptions;

public class RegraNegocioRunTime
        extends RuntimeException {

    public RegraNegocioRunTime(String msg) {
        super(msg);
    }
}