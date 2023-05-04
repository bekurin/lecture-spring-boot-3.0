import { PageResponse } from "../../../apis/PageResponse";
import { Paginate } from "../../../components/types";
import { ISpot } from "../../spot/types";

export interface RouteStates {
    pagedRoute: PageResponse<IRoute> | null;
}

export interface IRoute {
    id: number,
    spotList: ISpot[]
}

export interface RouteCallbacks {
    fetchPagedRoute: (payload: RouteQueryParams, paginate: Paginate) => void;
}

export interface RouteQueryParams {
    routeId: number | null;
    routeName: string | null;
}