/* eslint-disable */

// @ts-nocheck

// noinspection JSUnusedGlobalSymbols

// This file was automatically generated by TanStack Router.
// You should NOT make any changes in this file as it will be overwritten.
// Additionally, you should also exclude this file from your linter and/or formatter to prevent it from being checked or modified.

import { createFileRoute } from '@tanstack/react-router'

// Import Routes

import { Route as rootRoute } from './routes/__root'
import { Route as ProtectedImport } from './routes/_protected'
import { Route as AuthImport } from './routes/_auth'

// Create Virtual Routes

const IndexLazyImport = createFileRoute('/')()
const ProtectedDashboardLazyImport = createFileRoute('/_protected/dashboard')()
const AuthAuthRegisterLazyImport = createFileRoute('/_auth/auth/register')()
const AuthAuthLoginLazyImport = createFileRoute('/_auth/auth/login')()

// Create/Update Routes

const ProtectedRoute = ProtectedImport.update({
  id: '/_protected',
  getParentRoute: () => rootRoute,
} as any)

const AuthRoute = AuthImport.update({
  id: '/_auth',
  getParentRoute: () => rootRoute,
} as any)

const IndexLazyRoute = IndexLazyImport.update({
  id: '/',
  path: '/',
  getParentRoute: () => rootRoute,
} as any).lazy(() => import('./routes/index.lazy').then((d) => d.Route))

const ProtectedDashboardLazyRoute = ProtectedDashboardLazyImport.update({
  id: '/dashboard',
  path: '/dashboard',
  getParentRoute: () => ProtectedRoute,
} as any).lazy(() =>
  import('./routes/_protected/dashboard.lazy').then((d) => d.Route),
)

const AuthAuthRegisterLazyRoute = AuthAuthRegisterLazyImport.update({
  id: '/auth/register',
  path: '/auth/register',
  getParentRoute: () => AuthRoute,
} as any).lazy(() =>
  import('./routes/_auth/auth/register.lazy').then((d) => d.Route),
)

const AuthAuthLoginLazyRoute = AuthAuthLoginLazyImport.update({
  id: '/auth/login',
  path: '/auth/login',
  getParentRoute: () => AuthRoute,
} as any).lazy(() =>
  import('./routes/_auth/auth/login.lazy').then((d) => d.Route),
)

// Populate the FileRoutesByPath interface

declare module '@tanstack/react-router' {
  interface FileRoutesByPath {
    '/': {
      id: '/'
      path: '/'
      fullPath: '/'
      preLoaderRoute: typeof IndexLazyImport
      parentRoute: typeof rootRoute
    }
    '/_auth': {
      id: '/_auth'
      path: ''
      fullPath: ''
      preLoaderRoute: typeof AuthImport
      parentRoute: typeof rootRoute
    }
    '/_protected': {
      id: '/_protected'
      path: ''
      fullPath: ''
      preLoaderRoute: typeof ProtectedImport
      parentRoute: typeof rootRoute
    }
    '/_protected/dashboard': {
      id: '/_protected/dashboard'
      path: '/dashboard'
      fullPath: '/dashboard'
      preLoaderRoute: typeof ProtectedDashboardLazyImport
      parentRoute: typeof ProtectedImport
    }
    '/_auth/auth/login': {
      id: '/_auth/auth/login'
      path: '/auth/login'
      fullPath: '/auth/login'
      preLoaderRoute: typeof AuthAuthLoginLazyImport
      parentRoute: typeof AuthImport
    }
    '/_auth/auth/register': {
      id: '/_auth/auth/register'
      path: '/auth/register'
      fullPath: '/auth/register'
      preLoaderRoute: typeof AuthAuthRegisterLazyImport
      parentRoute: typeof AuthImport
    }
  }
}

// Create and export the route tree

interface AuthRouteChildren {
  AuthAuthLoginLazyRoute: typeof AuthAuthLoginLazyRoute
  AuthAuthRegisterLazyRoute: typeof AuthAuthRegisterLazyRoute
}

const AuthRouteChildren: AuthRouteChildren = {
  AuthAuthLoginLazyRoute: AuthAuthLoginLazyRoute,
  AuthAuthRegisterLazyRoute: AuthAuthRegisterLazyRoute,
}

const AuthRouteWithChildren = AuthRoute._addFileChildren(AuthRouteChildren)

interface ProtectedRouteChildren {
  ProtectedDashboardLazyRoute: typeof ProtectedDashboardLazyRoute
}

const ProtectedRouteChildren: ProtectedRouteChildren = {
  ProtectedDashboardLazyRoute: ProtectedDashboardLazyRoute,
}

const ProtectedRouteWithChildren = ProtectedRoute._addFileChildren(
  ProtectedRouteChildren,
)

export interface FileRoutesByFullPath {
  '/': typeof IndexLazyRoute
  '': typeof ProtectedRouteWithChildren
  '/dashboard': typeof ProtectedDashboardLazyRoute
  '/auth/login': typeof AuthAuthLoginLazyRoute
  '/auth/register': typeof AuthAuthRegisterLazyRoute
}

export interface FileRoutesByTo {
  '/': typeof IndexLazyRoute
  '': typeof ProtectedRouteWithChildren
  '/dashboard': typeof ProtectedDashboardLazyRoute
  '/auth/login': typeof AuthAuthLoginLazyRoute
  '/auth/register': typeof AuthAuthRegisterLazyRoute
}

export interface FileRoutesById {
  __root__: typeof rootRoute
  '/': typeof IndexLazyRoute
  '/_auth': typeof AuthRouteWithChildren
  '/_protected': typeof ProtectedRouteWithChildren
  '/_protected/dashboard': typeof ProtectedDashboardLazyRoute
  '/_auth/auth/login': typeof AuthAuthLoginLazyRoute
  '/_auth/auth/register': typeof AuthAuthRegisterLazyRoute
}

export interface FileRouteTypes {
  fileRoutesByFullPath: FileRoutesByFullPath
  fullPaths: '/' | '' | '/dashboard' | '/auth/login' | '/auth/register'
  fileRoutesByTo: FileRoutesByTo
  to: '/' | '' | '/dashboard' | '/auth/login' | '/auth/register'
  id:
    | '__root__'
    | '/'
    | '/_auth'
    | '/_protected'
    | '/_protected/dashboard'
    | '/_auth/auth/login'
    | '/_auth/auth/register'
  fileRoutesById: FileRoutesById
}

export interface RootRouteChildren {
  IndexLazyRoute: typeof IndexLazyRoute
  AuthRoute: typeof AuthRouteWithChildren
  ProtectedRoute: typeof ProtectedRouteWithChildren
}

const rootRouteChildren: RootRouteChildren = {
  IndexLazyRoute: IndexLazyRoute,
  AuthRoute: AuthRouteWithChildren,
  ProtectedRoute: ProtectedRouteWithChildren,
}

export const routeTree = rootRoute
  ._addFileChildren(rootRouteChildren)
  ._addFileTypes<FileRouteTypes>()

/* ROUTE_MANIFEST_START
{
  "routes": {
    "__root__": {
      "filePath": "__root.tsx",
      "children": [
        "/",
        "/_auth",
        "/_protected"
      ]
    },
    "/": {
      "filePath": "index.lazy.tsx"
    },
    "/_auth": {
      "filePath": "_auth.tsx",
      "children": [
        "/_auth/auth/login",
        "/_auth/auth/register"
      ]
    },
    "/_protected": {
      "filePath": "_protected.tsx",
      "children": [
        "/_protected/dashboard"
      ]
    },
    "/_protected/dashboard": {
      "filePath": "_protected/dashboard.lazy.tsx",
      "parent": "/_protected"
    },
    "/_auth/auth/login": {
      "filePath": "_auth/auth/login.lazy.tsx",
      "parent": "/_auth"
    },
    "/_auth/auth/register": {
      "filePath": "_auth/auth/register.lazy.tsx",
      "parent": "/_auth"
    }
  }
}
ROUTE_MANIFEST_END */
