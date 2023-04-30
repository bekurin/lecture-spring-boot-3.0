import axios from "axios";
import { IRoute, RouteQueryParams } from "../../pages/route/types";
import { Paginate } from "../../components/types";
import { PageResponse } from "../PageResponse";

const fetchPagedRouteApi = async (
    params: RouteQueryParams,
    paginate: Paginate
): Promise<PageResponse<IRoute>> => {
    const response = await axios.get(
        `v1/routes/page/${paginate.page}`,
        {
            params: {
                size: paginate.size,
                routeId: params.routeId,
                routeName: params.routeName
            }
        }
    );
    return response.data
}

export default fetchPagedRouteApi;