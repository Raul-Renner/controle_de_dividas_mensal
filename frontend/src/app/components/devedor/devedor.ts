import { Divida } from "../divida/divida";

export interface Devedor{
  id: number;
  nome: string;
  apelido: string;
  valor_total: number;
  dividas: Divida[];
}
