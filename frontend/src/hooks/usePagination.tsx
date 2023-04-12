import { useSearchParams } from "react-router-dom"

export interface Pagination {
    page: number,
    size: number
}

const usePagination = () => {
    const [searchParams, setSearchParams] = useSearchParams()
    const pagination = {
        page: parseInt(searchParams.get('page') || '0'),
        size: parseInt(searchParams.get('size') || '20')
    }

    const setPagination = (newPagination: Pagination) => {
        setSearchParams({
            page: `${newPagination.page}`,
            size: `${newPagination.size}`
        })
    }

    return {pagination, setPagination}
}

export default usePagination