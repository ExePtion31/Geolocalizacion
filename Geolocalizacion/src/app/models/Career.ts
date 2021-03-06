export class Career {
    id: string;
    carrera: string;
    facultad: string;

    constructor(id: string, carrera: string, facultad: string) {
        this.id = id;
        this.carrera = carrera;
        this.facultad = facultad;
    }
}

export class CareerCreate {
    carrera: string;
    facultad: string;

    constructor(carrera: string, facultad: string) {
        this.carrera = carrera;
        this.facultad = facultad;
    }
}