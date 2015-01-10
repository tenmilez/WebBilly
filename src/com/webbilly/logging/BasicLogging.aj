package com.webbilly.logging;

import org.aspectj.lang.Signature;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by christopher on 12/20/14.
 */
public aspect BasicLogging {

    pointcut controllersEntry(): execution(* com.webbilly.web..*Controller.*(..));

    before(): controllersEntry() {

        Signature sig = thisJoinPointStaticPart.getSignature();
        SimpleDateFormat formatter = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        String dateStr = formatter.format(new Date());
        logger.log(Level.INFO, dateStr + " Entering: " + sig.getDeclaringType().getName() + "." + sig.getName() + "(..);");
        logger.log(Level.INFO, "test");
        System.out.println("test2");
    }

    private Logger logger = Logger.getLogger("DEBUG"); //TODO fix this


}
