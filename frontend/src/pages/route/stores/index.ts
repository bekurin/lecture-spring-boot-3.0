import { create } from "zustand";
import { Paginate } from "../../../components/types";
import { RouteQueryParams } from "../types";
import { usePaginate } from "../../../hooks";
import { useQueryParams } from "../../../hooks";
import { useState } from "react";
import {PageResponse} from "../../../apis/PageResponse"
import { IRoute } from "../types";

const {paginate, setPaginate} = usePaginate()
const {queryParams, setQueryParams} = useQueryParams<RouteQueryParams>({
    routeId: null,
    routeName: null
})
const [pagedRoute, setPagedRoute] = useState<PageResponse<IRoute> | null>(null);

interface RouteStates {
    paginate: Paginate,
    queryParams: RouteQueryParams,
    pagedRoute: PageResponse<IRoute> | null
}

interface RouteCallbacks {
    updatePaginate: (paginate: Paginate) => void;
    updateQueryParams: (queryParams: RouteQueryParams) => void;
    updatePagedRoute: (pagedRoute: PageResponse<IRoute>) => void;
}

const useRouteStore = create<RouteStates & RouteCallbacks>((set) => ({
    paginate: paginate,
    queryParams: queryParams,
    pagedRoute: pagedRoute,
    updatePaginate: (paginate: Paginate) => setPaginate(paginate),
    updateQueryParams: (queryParams: RouteQueryParams) => setQueryParams(queryParams),
    updatePagedRoute: (pagedRoute: PageResponse<IRoute>) => setPagedRoute(pagedRoute)
}))

export default useRouteStore;
