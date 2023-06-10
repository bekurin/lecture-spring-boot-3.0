package com.backend.core.domain

import jakarta.persistence.*

@Entity
class Ticket(
    user: User,
    departureStation: Station,
    destinationStation: Station,
    route: Route,
) : BaseEntity() {
    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "user_id")
    var user: User = user
        protected set

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "station_id")
    var departureStation: Station = departureStation
        protected set

//    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
//    @JoinColumn(name = "station_id")
//    var destinationStation: Station = destinationStation
//        protected set

    @OneToOne(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "route_id")
    var route: Route = route
        protected set

}
