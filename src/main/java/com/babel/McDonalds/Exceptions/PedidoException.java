package com.babel.McDonalds.Exceptions;

import com.babel.McDonalds.model.Pedido;

public class PedidoException extends Exception{
    public PedidoException() {
        super();
    }

    public PedidoException(String message) {
        super(message);
    }

}
