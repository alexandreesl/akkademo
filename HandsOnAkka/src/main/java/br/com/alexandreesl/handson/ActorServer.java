package br.com.alexandreesl.handson;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

public class ActorServer {

	public static void main(String[] args) {

		ActorSystem server = ActorSystem.create("ActorServer");

		ActorRef personA = server.actorOf(Props.create(PersonA.class),
				"PersonA");

		for (int i = 0; i < 10; i++)
			personA.tell("Message to be delivered " + i, ActorRef.noSender());

	}

}
