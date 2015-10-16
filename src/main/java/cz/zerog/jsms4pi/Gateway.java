package cz.zerog.jsms4pi;

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
import cz.zerog.jsms4pi.event.InboundCallEventListener;
import cz.zerog.jsms4pi.event.InboundMessageEventListener;
import cz.zerog.jsms4pi.event.OutboundMessageEventListener;
import cz.zerog.jsms4pi.exception.GatewayException;
import cz.zerog.jsms4pi.message.OutboundMessage;
import cz.zerog.jsms4pi.notification.Notification;

/**
 *
 * @author zerog
 */
public interface Gateway {

    public void open() throws Exception;

    public void close() throws Exception;

    public boolean init() throws GatewayException;
//
//    public void setGlobalDeliveryReport(boolean report);
//
//    public void setGlobalValidityPeriod(boolean period);

    public String getPortName();

    void notify(Notification notifi);

    public void setOutboundMessageEventListener(OutboundMessageEventListener listener);

    public void setInboundCallListener(InboundCallEventListener callListener);

    public void setInboundMessageListener(InboundMessageEventListener listener);
    
    public boolean isReadyToSend();
    
    public void sendMessage(OutboundMessage message) throws GatewayException;
    
    public boolean isAlive();

}