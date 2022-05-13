export class Student {
    id: number;
    nombre: string;
    correo: string;
    password: string;
    jornada: string;
    carrera: string;
    role: number;

    constructor(id: number, nombre: string, correo: string, password: string, jornada: string, carrera: string ,role: number) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.jornada = jornada;
        this.carrera = carrera;
        this.role = role;
    }
}

export class StudentCreate {
    nombre: string;
    correo: string;
    password: string;
    jornada: string;
    carrera: string;
    role: number;

    constructor(nombre: string, correo: string, password: string, jornada: string, carrera: string ,role: number) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.jornada = jornada;
        this.carrera = carrera;
        this.role = role;
    }
}
