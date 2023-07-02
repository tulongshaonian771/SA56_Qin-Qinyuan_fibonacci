package Oralce2.resources;
import Oralce2.api.Saying ;
import com.codahale.metrics.annotation.Timed;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/FibonacciSequence")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWordResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWordResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("element") Integer element) {
        Double n1 = 1.0;
        Double n2 = 1.0;
        Double cur = 0.0;
        List<Double> fib = new ArrayList<>();
        List<Double> sorted = new ArrayList<>();

        if (element == 1) {
            fib.add(0.0);
            fib.add(n1);
            sorted = fib;
            return new Saying(fib,sorted);
        }

        if (element == 2) {
            fib.add(0.0);
            fib.add(n1);
            fib.add(n2);
          sorted= fib;
            return new Saying(fib,sorted);
        }
        if (element > 2) {
            fib.add(0.0);
            fib.add(n1);
            fib.add(n2);
            for (int i = 2; i <element; i++) {
                cur = n1 + n2;
                n1 = n2;
                n2 = cur;
                fib.add(cur);
            }
            for (int k=element;k>=0;k--)
            {
                if (fib.get(k)%2 == 0)
                sorted.add(fib.get(k));
            }
            for (int k=element;k>=0;k--)
            {
                if (fib.get(k)%2 != 0)
                    sorted.add(fib.get(k));
            }
            return new Saying(fib,sorted);
        }
      return new Saying();
    }
}