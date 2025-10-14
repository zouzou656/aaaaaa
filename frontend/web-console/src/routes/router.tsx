import { createBrowserRouter } from 'react-router-dom';
import { Layout } from '../components/Layout';
import { Dashboard } from '../pages/Dashboard';
import { FlowDesigner } from '../pages/FlowDesigner';
import { MappingStudio } from '../pages/MappingStudio';
import { RulesStudio } from '../pages/RulesStudio';
import { ValidationSets } from '../pages/ValidationSets';
import { Deployments } from '../pages/Deployments';
import { Operations } from '../pages/Operations';
import { Analytics } from '../pages/Analytics';
import { Audit } from '../pages/Audit';
import { Settings } from '../pages/Settings';

export const router = createBrowserRouter([
  {
    path: '/',
    element: <Layout />,
    children: [
      { index: true, element: <Dashboard /> },
      { path: 'flows', element: <FlowDesigner /> },
      { path: 'mappings', element: <MappingStudio /> },
      { path: 'rules', element: <RulesStudio /> },
      { path: 'validations', element: <ValidationSets /> },
      { path: 'deployments', element: <Deployments /> },
      { path: 'operations', element: <Operations /> },
      { path: 'analytics', element: <Analytics /> },
      { path: 'audit', element: <Audit /> },
      { path: 'settings', element: <Settings /> }
    ]
  }
]);
