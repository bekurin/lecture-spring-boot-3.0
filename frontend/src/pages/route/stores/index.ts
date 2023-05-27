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

export const useRouteStore = create((set) => ({
    paginate: paginate,
    queryParams: queryParams,
    pagedRoute: pagedRoute,
    updatePaginate: (paginate: Paginate) => set(() => (setPaginate(paginate))),
    updateQueryParams: (queryParams: RouteQueryParams) => set(() => setQueryParams(queryParams)),
    updatePagedRoute: (pagedRoute: PageResponse<IRoute>) => set(() => setPagedRoute(pagedRoute))
}))