
export interface ISpot {
    id: number;
    name: string;
    position: Position;
}

export interface Position {
    latitude: number,
    longitude: number
}