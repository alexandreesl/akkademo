package br.com.alexandreesl.handson;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PostMan extends UntypedActor {

	private ActorRef personB;

	private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void preStart() throws Exception {
		super.preStart();

		personB = getContext().actorOf(Props.create(PersonB.class), "PersonB");

	}

	@Override
	public void onReceive(Object message) throws Exception {

		log.info("Go to the address with the letter");

		log.info("Deliver the letter to personB");

		personB.tell(message, getSelf());

	}

}
