While implementing Circuit breaker using Resiliency4j, below are necessary things,

* Spring AOP dependency
* Spring Actuator (For tracking status of Circuit break/Failure calls) metrics
* Resiliency4j dependency

-------------
MUST dos while implementing CB

* fallbackMethod should be present in same class
* fallbackMethod should have the same return type as that of the acutal call method
* fallbackMethod should take (Exception e) as input parameter
* Main method should not throw any exception explicitly
