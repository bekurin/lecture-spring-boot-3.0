import usePagination from "../../hooks/usePagination"
import useQueryParams from "../../hooks/useQueryParams"

interface helloQueryParams {
    id: number,
    name: string
}

const Hello = () => {
    const {pagination, setPagination} = usePagination()
    const {queryParams, setQueryParams} = useQueryParams<helloQueryParams>({
        id: 1, name: "홍길동"
    })

    return (
        <div>
            <h1>${queryParams.id}</h1>
            <h1>${queryParams.name}</h1>
            <button onClick={event => setQueryParams({id: 1, name: "안녕"})}>값 변경</button>
        </div>
    )
}

export default Hello