import { useEffect } from "react"
import { usePaginate, useQueryParams } from "../../hooks"
import { RouteCallbacks, RouteQueryParams, RouteStates } from "./types"
import { Card } from "primereact/card";

type PropsType = {
    callbacks: RouteCallbacks,
    states: RouteStates
}

const Route = ({states, callbacks}: PropsType) => {
    const {paginate, setPaginate} = usePaginate()
    const {queryParams, setQueryParams} = useQueryParams<RouteQueryParams>({
        routeId: null,
        routeName: ""
    })

    useEffect(() => {
        callbacks.fetchPagedRoute(queryParams, paginate)
    }, [
        queryParams.routeId,
        queryParams.routeName,
        paginate.page,
        paginate.size
    ])

    return (
        <Card title="경로 검색">
        </Card>
    )
}

export default Route;