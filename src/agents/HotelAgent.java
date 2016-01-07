/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package agents;

/**
 *
 * @author Linaco
 */
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;
import objects.Hotel;
import objects.Request;

import java.io.Serializable;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import behaviour.InitiatorSend;
import behaviour.MessageReceiveAgent;
import behaviour.WindowRefresh;
import util.AgentFrame;

public class HotelAgent extends WorkingAgent {

	public AID providerAID = null;

	@Override
	public void setup() {
		Object[] args = this.getArguments();
		if (args != null) {
			windowsForm = (AgentFrame) args[0];
		}
		windowsForm.setTitle(this.getName());
		windowsForm.setVisible(true);
		
		Hotel.lastIndex = 0;
		
		addBehaviour(new WindowRefresh(this,1000));
		addBehaviour(new MessageReceiveAgent(this));
		addBehaviour(new InitiatorSend(this));
	}
	
	@Override
	public Serializable search(Request request){
		
		
		return null;
	}
}