import { useSearchParams } from 'react-router-dom';

interface QueryParams<T> {
  data: T;
}

const useQueryParams = <T extends Object>(initialQueryParams: T)=> {
    const [searchParams, setSearchParams] = useSearchParams()
    const queryParams = (): T => {
        const urlSearchParams = new URLSearchParams()
        Object.keys(initialQueryParams).map((value) => {
            urlSearchParams.append(value, `${searchParams.get(value)}`)
        })
        return JSON.parse(urlSearchParams.toString()) as T
    }

    const setQueryParams = (newQueryParams: T) => {
        const urlSearchParams = new URLSearchParams()
        Object.entries(newQueryParams).map(([key, value]) => {
            urlSearchParams.append(key, value)
        })
        setSearchParams(urlSearchParams)
    }

    return {queryParams: queryParams(), setQueryParams}
}

export default useQueryParams