import {Profession} from "./profession";

export interface DoctorInfo{
  id?: number,
  imagePath?: string,
  description?: string,
  address?: string,
  professionList?: Profession[]
}
