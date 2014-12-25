package br.com.alexandreesl.handson;

import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PersonA extends UntypedActor {

	private ActorRef postRecepcionist;

	private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void preStart() throws Exception {
		super.preStart();

		postRecepcionist = getContext().actorOf(
				Props.create(PostReceptionist.class), "PostRecepcionist");

	}

	@Override
	public void onReceive(Object message) throws Exception {

		log.info("Receiving the letter");

		log.info("Going to the post office");

		log.info("Delivering the letter to the post recepcionist");

		postRecepcionist.tell(message, getSelf());

	}

}
