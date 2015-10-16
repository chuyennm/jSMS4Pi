/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.zerog.jsms4pi.exception;

/*
 * #%L
 * jSMS4Pi
 * %%
 * Copyright (C) 2015 jSMS4Pi
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

import cz.zerog.jsms4pi.NullGateway;
import cz.zerog.jsms4pi.Service;
import cz.zerog.jsms4pi.event.InboundMessageEvent;
import cz.zerog.jsms4pi.event.InboundMessageGatewayEventListener;
import java.io.IOException;

/**
 *
 * @author zerog
 */
public class Test implements InboundMessageGatewayEventListener{
    public static void main(String[] args) throws IOException {
        new Test().doIt();
    }
    
    public void doIt() throws IOException {
        Service s = Service.getInstance();
        
       s.setInboundMessageGatewayEventListener(this);
       s.addGateway(new NullGateway("1", 1), "null1"); 
       s.addGateway(new NullGateway("2", 2), "null2");
       s.addGateway(new NullGateway("4", 4), "null4");
       s.addGateway(new NullGateway("42", 4), "null42");
        System.in.read();
    }

    @Override
    public void inboundMessageEvent(String gatewayName, InboundMessageEvent inboundMessageEvent) {
        System.out.println("New message by "+gatewayName+" from tel: "+inboundMessageEvent.getMessage().getSource());
    }
}