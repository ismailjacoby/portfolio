export interface LoginForm {
  username: string,
  password: string
}

export enum UserRole {
  ADMIN
}

export interface AuthDTO {
  username: string,
  token: string,
  role: UserRole
}
