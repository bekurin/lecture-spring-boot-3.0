import { useState } from "react";
import Route from "./Route";
import { IRoute, RouteCallbacks, RouteQueryParams, RouteStates } from "./types";
import { PageResponse } from "../../apis/PageResponse";
import { Paginate } from "../../components/types";
import fetchPagedRouteApi from "../../apis/route/fetchPagedRouteApi";
import { useRouteStore } from "./stores";

const RouteContainer = () => {
    const [pagedRoute, setPagedRoute] =   useRouteStore()
    
    const fetchPagedRoute =async (
        params: RouteQueryParams,
        paginate: Paginate
     ) => {
        const response =  await fetchPagedRouteApi(params, paginate)
        setPagedRoute(response)
    }

    const callbacks: RouteCallbacks = {
        fetchPagedRoute
    }
    const states: RouteStates = {
        pagedRoute
    }
    return <Route callbacks={callbacks} states={states} />
}

export default RouteContainer;