import Button from "primereact/button"
import { Form, Field } from 'react-final-form';
import { RouteQueryParams } from "./types"

type PropsType = {
    queryParams: RouteQueryParams,
    setQueryParams: (routeQueryParams: RouteQueryParams) => void;
}

const RouteSearch = ({queryParams, setQueryParams}: PropsType) => {
    const onSubmitEventHandler = (queryParams: RouteQueryParams) => {
        setQueryParams(queryParams)
    }

    return (
        <Form 
            onSubmit={onSubmitEventHandler}
            initialValues={{routeId: null, routeName: ""}}
        />
    )
}

export default RouteSearch