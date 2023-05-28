import Route from "./Route";
import { IRoute, RouteCallbacks, RouteQueryParams, RouteStates } from "./types";
import { PageResponse } from "../../apis/PageResponse";
import { Paginate } from "../../components/types";
import fetchPagedRouteApi from "../../apis/route/fetchPagedRouteApi";
import { usePaginate } from "../../hooks";
import { useQueryParams } from "../../hooks";
import useRouteStore from "./stores";

const RouteContainer = () => {
    const {pagedRoute, updatePagedRoute} = useRouteStore();

    const fetchPagedRoute =async (
        params: RouteQueryParams,
        paginate: Paginate
     ) => {
        const response =  await fetchPagedRouteApi(params, paginate)
        updatePagedRoute(response)
    }
    return <Route callbacks={callbacks} states={states} />
}

export default RouteContainer;