package br.com.alexandreesl.handson;

import scala.Option;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class PersonB extends UntypedActor {

	int counter = 0;

	private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public void preRestart(Throwable reason, Option<Object> message)
			throws Exception {

		log.info("THE PERSONB IS BOOTING!");

		super.preRestart(reason, message);
	}

	@Override
	public void onReceive(Object message) throws Exception {

		log.info("Reads the letter");

		if (counter % 2 != 0)
			throw new RuntimeException("ERROR!");

		counter++;

	}

}
