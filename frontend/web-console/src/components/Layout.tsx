import { NavLink, Outlet } from 'react-router-dom';

const navItems = [
  { to: '/', label: 'Dashboard' },
  { to: '/flows', label: 'Flows' },
  { to: '/mappings', label: 'Mappings' },
  { to: '/rules', label: 'Rules' },
  { to: '/validations', label: 'Validation Sets' },
  { to: '/deployments', label: 'Deployments' },
  { to: '/operations', label: 'Operations' },
  { to: '/analytics', label: 'Analytics' },
  { to: '/audit', label: 'Audit' },
  { to: '/settings', label: 'Settings' }
];

export function Layout() {
  return (
    <div className="min-h-screen flex">
      <nav className="w-60 bg-slate-900 text-white p-4 space-y-2">
        <h1 className="text-xl font-bold">Stratum</h1>
        <ul className="space-y-1">
          {navItems.map(item => (
            <li key={item.to}>
              <NavLink className={({ isActive }) => `block rounded px-3 py-2 ${isActive ? 'bg-slate-700' : 'hover:bg-slate-800'}`} to={item.to} end={item.to === '/'}>
                {item.label}
              </NavLink>
            </li>
          ))}
        </ul>
      </nav>
      <main className="flex-1 p-6 bg-slate-100 dark:bg-slate-800 text-slate-900 dark:text-slate-100">
        <Outlet />
      </main>
    </div>
  );
}
