# springCitibike

Example of using a Hazelcast (Hz) cluster across two nodes, implemented using two seperate modules, each containing a Spring Boot application.

**citiBikeIngester**- responsible for gathering data from the citibike endpoint and storing it in Hz

**citiBikeAPI** - responsible for handling requests and returning data from Hz
