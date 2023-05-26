import { create } from "zustand";

const useRouteStore = create((set) => ({
    routeId: 0,
}))