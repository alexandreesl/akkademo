package br.com.alexandreesl.handson;

import scala.concurrent.duration.Duration;
import akka.actor.ActorRef;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Function;

public class PostReceptionist extends UntypedActor {

	private ActorRef postMan;

	private LoggingAdapter log = Logging.getLogger(getContext().system(), this);

	@Override
	public SupervisorStrategy supervisorStrategy() {
		return new OneForOneStrategy(-1, Duration.Inf(),
				new Function<Throwable, Directive>() {
					public Directive apply(Throwable t) throws Exception {
						return OneForOneStrategy.restart();
					}
				});
	}

	@Override
	public void preStart() throws Exception {
		super.preStart();

		postMan = getContext().actorOf(Props.create(PostMan.class),
				"PostMan");

	}

	@Override
	public void onReceive(Object message) throws Exception {

		log.info("Organizing the letters");

		log.info("Delivering the letters to the Postman");

		postMan.tell(message, getSelf());

	}

}
